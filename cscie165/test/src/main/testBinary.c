#include <stdio.h>
#include <string.h>
#include <stdlib.h>


typedef struct column {
    char* name;
    int* data;
} column;

typedef struct table {
    char* name;
    size_t col_count;
    column* col;
    size_t length;
    size_t current_col_count; // used to track index of last inserted col.
} table;

typedef struct db {
    char* name;
    size_t table_count;
    table* tables;
} db;

void write_file(db* db1);
void write_tables(db* db1, FILE* ptr_myfile);
db* read_file();
table* read_tables();

int main()
{
    //int counter;
    //FILE *ptr_myfile;
    db* my_db = malloc(sizeof(db));
    char* dbName = malloc(sizeof(char)* 5);
    strncpy(dbName, "MyDB", 4);
    dbName[4] = '\0';

    column* col1 = malloc(sizeof(column));
    char* col1Name = malloc(sizeof(char)* 5);
    strncpy(col1Name, "col1", 4);
    dbName[4] = '\0';
    int* col1Data = malloc(sizeof(int)*10);
    for(int kk=0; kk<10; kk++){
        col1Data[kk] = kk+1;
    }
    col1->name = col1Name;
    col1->data = col1Data;

    char* name1 = "tb1";
    char* name2 = "tb2";
    char* name3 = "tb3";
    char* name4 = "tb4";

    table* tbls = malloc(sizeof(table)*4);

    for(int t=0;t<4;t++){
        //table* tt = malloc(sizeof(table));
        char* tbName = malloc(sizeof(char)* 4);
        if(t==0)
            strncpy(tbName, name1, strlen(name1));
        else if(t==1)
            strncpy(tbName, name2, strlen(name2));
        else if(t==2)
            strncpy(tbName, name3, strlen(name3));
        else if(t==3)
            strncpy(tbName, name4, strlen(name4));

        tbName[3] = '\0';
        tbls[t].name = tbName;
        tbls[t].col_count = 1;
        tbls[t].length = 10;
        tbls[t].col = col1;
    }

    my_db->name = dbName;
    my_db->table_count = 4;
    my_db->tables = tbls;

    printf("Name of the db is %s\n", my_db->name);
    printf("Total tables of the db is %zu\n", my_db->table_count);
    for(int i =0; i<my_db->table_count ; i++){
        printf("Name of the tbl %s\n", my_db->tables[i].name);
        for(int j=0; j<my_db->tables[i].col_count; j++){
            printf("Name of the col %s\n", my_db->tables[i].col[j].name);
        }
    }

    printf("Attempting to write to the file\n");


    write_file(my_db);


    db* r_db = read_file();
    printf("################ After reading the file #################\n");
    printf("Name of the db is %s\n", r_db->name);
    printf("Total tables of the db is %zu\n", r_db->table_count);

    for(int i =0; i<my_db->table_count ; i++){
        printf("Name of the tbl %s\n", my_db->tables[i].name);
        printf("col_count of table %zu\n", my_db->tables[i].col_count);
        printf("length of the cols in tbl %zu\n", my_db->tables[i].length);
        for(int j=0; j<my_db->tables[i].col_count; j++){
            printf("Name of the col %s\n", my_db->tables[i].col[j].name);
            for(int k=0; k<my_db->tables[i].length; k++){
                printf("Value of col at index k :%i is : %i\n", k, my_db->tables[i].col[j].data[k]);
            }
        }
    }

    // for(int i = 0; i< 4; i++){
    //      free(my_db->tables[i].name);
    //      for(int j=0; j< my_db->tables[i].col_count; i++){
    //         free(my_db->tables[i].col[j].name);
    //         free(my_db->tables[i].col[j].data);
    //      }
    //      free(my_db->tables[i].col);
    //      //free(my_db->tables[i]);
    // }
    free(my_db->tables);
    free(my_db->name);
    free(my_db);
    return 0;
}

    // #include<stdio.h>



void write_file(db* db1){
    FILE* ptr_myfile=fopen("test.bin","wb");
    if (!ptr_myfile)
    {
        printf("Unable to open file!");
    }
    if(db1 != NULL)
    {
        //length of the name, name itself....
        int len = strlen(db1->name);
        printf("Length of the name is %i\n", len);

        fwrite(&len, sizeof(int), 1, ptr_myfile);
        fwrite(db1->name, sizeof(char),len, ptr_myfile);

        write_tables(db1, ptr_myfile);


        printf("Done writing \n");
    }

    fclose(ptr_myfile);
}

void write_columns(table* tbl, FILE* ptr_myfile){
    if (!ptr_myfile)
    {
        printf("Unable to open file!");
    }
    if(tbl != NULL)
    {
        //length of the name, name itself....

        int totalCols = tbl->col_count;
        int colLength = tbl->length;

        for(int i=0; i<totalCols; i++){
            column col = tbl->col[i];

            int len = strlen(col.name);
            printf("Length of the name is %i\n", len);

            fwrite(&len, sizeof(int), 1, ptr_myfile);
            fwrite(col.name, sizeof(char),len, ptr_myfile);
            fwrite(col.data, sizeof(int),colLength, ptr_myfile);
        }
        printf("Done writing cols\n");
    }


}

void write_tables(db* db1, FILE* ptr_myfile){
    if (!ptr_myfile)
    {
        printf("Unable to open file!");
    }
    if(db1 != NULL)
    {
        //length of the name, name itself....

        int totalTbls = db1->table_count;
        fwrite(&totalTbls, sizeof(int), 1, ptr_myfile);

        for(int i=0; i<totalTbls; i++){
            table tbl = db1->tables[i];

            int len = strlen(tbl.name);
            printf("Length of the name is %i\n", len);

            fwrite(&len, sizeof(int), 1, ptr_myfile);
            fwrite(tbl.name, sizeof(char),len, ptr_myfile);
            fwrite(&tbl.col_count, sizeof(int),1, ptr_myfile);
            fwrite(&tbl.length, sizeof(int),1, ptr_myfile);
            write_columns(&tbl, ptr_myfile);
        }
        printf("Done writing tables\n");
    }


}


column* read_cols(FILE *ptr_myfile, int col_count, int col_length){

    if (!ptr_myfile)
    {
        printf("Unable to open file!");
        return NULL;
    }

    column* cols = NULL;

    for(int i=0; i<col_count; i++){

        int nameLen = 0;
        fread(&nameLen, sizeof(int), 1, ptr_myfile);
        //printf("col name has length %i\n", nameLen);

        char* cName = malloc(sizeof(char) * (nameLen+1));

         fread(cName, sizeof(char), nameLen, ptr_myfile);
         //printf("col name is %s\n", cName);
        int* colData = NULL;

        if(col_length > 0){
            colData = malloc(sizeof(int) * col_length);
            fread(colData, sizeof(int),col_length,ptr_myfile);
            // for(int i = 0; i< col_length; i++){
            //     printf("value at i: %i is %i\n", i, colData[i]);
            // }
        }
        column* newcols = realloc(cols, 1);
        if( newcols != NULL)
            cols = newcols;

        cols[i].name = cName;
        cols[i].data = colData;
    }
    return cols;
}


table* read_tables(FILE *ptr_myfile, int len){

    if (!ptr_myfile)
    {
        printf("Unable to open file!");
        return NULL;
    }

    table* tbls = NULL;

        for(int i=0; i<len; i++){

            int nLen = 0;

            fread(&nLen,sizeof(int),1,ptr_myfile);

            //printf("The name of the table at %i has length :%i\n", i, nLen);

            char* name = malloc(sizeof(char) * (nLen+1));

            fread(name,sizeof(char),nLen, ptr_myfile);

            name[nLen] = '\0';

            //printf("read name %s\n", name);


            int col_count = 0;
            fread(&col_count,sizeof(int),1,ptr_myfile);
            //printf("col count %i\n", col_count);

            int col_length = 0;
            fread(&col_length,sizeof(int),1,ptr_myfile);
            //printf("col length %i\n", col_length);


            column* cs = read_cols(ptr_myfile, col_count, col_length);

            table* newTbls = realloc(tbls, 1);
            if(newTbls != NULL)
                tbls = newTbls;
            tbls[i].name = name;
            tbls[i].col_count = col_count;
            tbls[i].length = col_length;
            tbls[i].col = cs;

        }

     return tbls;

}

db* read_file()
{
    //int counter;
    FILE *ptr_myfile;
    //struct rec my_record;

    ptr_myfile=fopen("test.bin","rb");
    if (!ptr_myfile)
    {
        printf("Unable to open file!");
        return NULL;
    }

        int len = 0;
        fread(&len,sizeof(int),1,ptr_myfile);

        printf("Length of the name is :%i\n", len);

        char* name = malloc(sizeof(char) * (len+1));

        fread(name,sizeof(char),len,ptr_myfile);
        name[len] = '\0';
        printf("read name %s\n", name);

        int tbl_len = 0;
        fread(&tbl_len,sizeof(int),1,ptr_myfile);

        printf("Total tables :%i\n", tbl_len);

        table* ts = read_tables(ptr_myfile, tbl_len);

        db* database = malloc(sizeof(db));
        database->name = name;
        database->table_count = len;
        database->tables = ts;


    fclose(ptr_myfile);

    return database;
}
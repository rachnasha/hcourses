#include <stdio.h>
#include <string.h>
 
int main(void)
{
        char* str = "t1=insert(\"tbl\")";
        char* str11 = "create(\"tb\")";
        char* sep = "=";
       char* str1 = strstr(str, sep); // find separator
       //char* str2 = strstr(str11, sep); // find separator
       if(str1) {
        printf("There are words %s\n", str1 );
        // check the first six charaters equal to create
        char dest[7];
        memcpy(dest,str1+1,6);
        printf("There are words %s\n", dest);
        if(strcmp("create", dest) == 0){
           printf("This is a CREATE COMMAND\n");
        
        // now check what is present after the 2 characters
        char dest1[3];
        memcpy(dest1, str1+9, 2);
        printf("dest1 now has \n");
        if(strcmp("tb", dest1)==0){
         printf("This is a create table command\n");
        }
        else if(strcmp("db", dest1)==0){
          printf("this is a create db command\n");
        }
        else{
         printf("seems like a new command , dest has %s\n", dest1);
        }
     }
        else{
         printf("This is not a CREATE command\n");
        }
        
       }

}

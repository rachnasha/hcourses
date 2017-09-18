#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int readHeader(char* headerStream, char* hdrs){

  char* headers = strtok(headerStream, ",");
  while(headers != NULL){

    char* rhd = realloc(hdrs, strlen(token)+1);
    if(rhd == NULL){
      return -1;
    }



    headers = strtok(NULL, ",");
  }

  return 0;

}


int main(void)
{
    char buffer[4096]; // read a page worth.
    char* input = NULL;
    size_t cur_len = 0;
    size_t counter = 0;

   FILE* fp = fopen("/Users/rsha/harvardCourses/cscie165/rachnashas-cs165-2015-base/project_tests/t3.data", "r");
   //FILE* fp = fopen("/Users/rsha/harvardCourses/cscie165/rachnashas-cs165-2015-base/project_tests/t2.data", "r");
    if (fp == NULL)
      return -1;

    while (fgets(buffer, sizeof(buffer), fp) != 0)
    {
        counter = counter+1;
        printf("came in loop of while :%zu : \n", counter);
        size_t buf_len = strlen(buffer); // reads one less than buffer size ( last one is for \0)
        printf("buf length read : %zu : current_len : %zu \n", buf_len, cur_len );
        char* extra = realloc(input, buf_len + cur_len + 1); // allocate mem.
        if (extra == 0)
            break;
        input = extra; // input is of size 4096
        strcpy(input + cur_len, buffer);
        cur_len += buf_len;
    }
    printf("\n");
    //printf("%s [%d]", input, (int)strlen(input));
    //printf("[%d]",  (int)strlen(input));
    int counter1 = 0;
    char* token = strtok(input, "\n");
    while(token != NULL){
      //counter1 += 1;
      //printf("%s first token \n", token);
      if(counter1 == 0){
        readHeader(token);
      }

      printf("read counter : %i\n", counter1);
      token = strtok(NULL,"\n");
    }




    free(input);



    return 0;
}







  //  #include <stdio.h>
  //  #include <stdlib.h>

  //  int main(void)
  //  {
  //   FILE * fp;
  //   char * line = NULL;
  //   size_t len = 0;
  //   ssize_t read;

  //   fp = fopen("/Users/rsha/harvardCourses/cscie165/rachnashas-cs165-2015-base/project_tests/t3.data", "r");
  //   if (fp == NULL)
  //     return -1;

  //   while ((read = getline(&line, &len, fp)) != -1) {
  //      printf("Retrieved line of length %zu :\n", read);
  //      printf("%s", line);
  //      char* token = strtok(line,",");
  //      while(token != NULL){

  //      }
  //   }

  //   fclose(fp);
  //   if (line)
  //     free(line);
  //   return 0;
  // }

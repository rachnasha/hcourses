#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void readFirstFourChar(char* str, char* dest)
{
       char* sep = "=";
       char* str1 = strstr(str, sep); // find separator
       if(str1) {
        // check the first six charaters equal to create
        memcpy(dest,str1+1,4);
       }else{
        memcpy(dest,str1,4);
       }
        printf("There are words %s\n", dest);
}

char* extract(char* str){
    const char *p1 = strstr(str, "(")+1;
    const char *p2 = strstr(p1, ")");
    size_t len = p2-p1;
    char* res = (char*)malloc(sizeof(char)*(len));
    strncpy(res, p1, len);
    res[len] = '\0';
    printf("'%s'\n", res);
    return res;
}



int main(void)
{
        char* str = "t1=load(tbl,\"t1\",\"t3\",1)";
        char* str11 = "create(\"tb\")";
       //char* str2 = strstr(str11, sep); // find separator
       //For the current set of commands we are supporting reading
       // just four char is all that is needed to make the right decision.
       // In future if any command gets added that makes decisionmaking with
       // first four chars difficult ...
        char firstFour[5] = {0};
        readFirstFourChar(str,firstFour);

           if(strcmp("load", firstFour)==0){
                printf("This is a load command\n");
                char* ret = extract(str);
                //char* ind = strchr(str, '(');
                
              // char s[] = "this is a string";
for (char* p = strtok(ret,"\","); p != NULL; p = strtok(NULL, "\","))
{
      puts(p);
}
              //}
           }
           else if(strcmp("sele", firstFour)==0)
                printf("This is a select command\n");
           else if(strcmp("crea", firstFour)==0)
                printf("This is a create command\n");
           else if(strcmp("tupl", firstFour)==0)
                 printf("This is a c tuple command\n");
          else if(strcmp("rela", firstFour)==0)
                 printf("This is a relation_insert command\n");
           else if(strcmp("fetc", firstFour)==0)
                 printf("This is a fetch command\n");
            else
                printf("No Match found\n");
}

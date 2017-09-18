#include <stdlib.h>
#include <stdio.h>

int main(int argc, const char * argv[]) {

    void* myarray  = NULL;
    size_t size = 0;

    size++;
    myarray =  realloc(myarray, sizeof(int) * size);
    int* idx = (int*)(myarray + sizeof(int) * (size - 1));
    (*idx) = 1;

    size++;
    myarray =  realloc(myarray, sizeof(int) * size);
    idx = (int*)(myarray + sizeof(int) * (size - 1));
    *idx = 2;

    size++;
    myarray =  realloc(myarray, sizeof(int) * size);
    idx = (int*)(myarray + sizeof(int) * (size - 1));
    *idx = 3;

    size++;
    myarray =  realloc(myarray, sizeof(int) * size);
    idx = (int*)(myarray + sizeof(int) * (size - 1));
    *idx = 4;

    size++;
    myarray = realloc(myarray, sizeof(int) * size); // I get a crash here????
    idx = (int*)(myarray + sizeof(int) * (size - 1));
    *idx = 5;


    for(size_t i=0; i < size; i++) {
        int *idx = (int*)(myarray + sizeof(int) * i);
        printf("index: %d\n", *idx);
    }

    free(myarray);
}
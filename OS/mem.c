#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include "common.h"

// int value = 5;

int main(int argc, char *argv[]) {
    int value = 5;
    int *p = malloc(sizeof(int));
    // int *p = &value;
    assert(p != NULL);
    printf("(%d) address of p: %d\n", getpid(), &p); // &p is address of p
    printf("(%d) address pointed by p: %p\n", getpid(), p); // p is same as &value, is the address of value
    // *p is tha value pointed by pointer p, which is 5
    
    *p = atoi(argv[1]);
    int i = 0;
    while(i < 5) {
        Spin(1);
        *p += 1;
        i++;
        printf("(%d) p: %d\n", getpid(), *p);
    }
    return 0;
}
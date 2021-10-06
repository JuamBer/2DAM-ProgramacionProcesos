#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <stdbool.h>

#define TAM_BUF 40

int main()
{
    int fp;
    char buffer[TAM_BUF];
    int nbytes;
    mknod("FIFO1", S_IFIFO | 0660, 0);

    while (true)
    {
        fp = open("FIFO1", O_RDONLY);
        nbytes = read(fp, buffer, TAM_BUF);
        buffer[nbytes] = '\0';
        printf("Cadena rebuda: %s \n", buffer);
        close(fp);
    }

    return 0;
}

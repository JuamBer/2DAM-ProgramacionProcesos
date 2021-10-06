#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>

int main()
{
    int fd[2];
    pid_t pid;
    char msgchild[] = "Hola Papi\0";
    char buffer[sizeof(msgchild) + 1];

    pipe(fd);     // CREE EL PIPE
    pid = fork(); // CREE EL PROCÉS FILL
    switch (pid)
    {
    case 1: //ERROR
        printf("No s'ha pogut crear el procés fill\n");
        exit(1);
    case 0:                                           // PROCÉS FILL REP
        close(fd[0]);                                 // TANCA EL DESCRIPTOR D'EIXIDA
        write(fd[1], msgchild, strlen(msgchild) + 1); // ESCRIU
        printf("El fill envia al pare...\n");
        break;
    default: // PROCÉS PARE ENVIA
        wait(NULL);
        close(fd[1]); // TANCA EL DESCRIPTOR D'ENTRADA
        read(fd[0], buffer, sizeof(buffer) + 1);
        printf("El pare rep del fill: %s\n", buffer);
        // ESCRIU
        //espero al proceso hijo
        break;
    }
    return 0;
}

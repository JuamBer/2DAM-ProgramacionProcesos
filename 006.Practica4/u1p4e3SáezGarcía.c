#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>

int main()
{
    pid_t pid1, pid2, pid3;
    int status1, status2, status3;
    pid1 = fork();

    switch (pid1){
    case 1:
        printf("No s'ha pogut crear el procés fill\n");
        exit(1);
    case 0:
        waitpid(pid1, &status1, 0);
        printf("Soc fill (%d, fill de %d )\n", getpid(), getppid());
        pid2 = fork();
        switch (pid2){
        case 1:
            printf("No s'ha pogut crear el procés fill\n");
            exit(1);
        case 0:
            waitpid(pid3, &status3, 0);
            printf("Soc net (%d, fill de %d )\n", getpid(), getppid());
            break;
        }
        break;
    default:
        printf("Soc pare (%d, fill de %d )\n", getpid(), getppid());
        pid3 = fork();
        switch (pid3)
        {
        case 1:
            printf("No s'ha pogut crear el procés fill\n");
            exit(1);
        case 0:
            waitpid(pid2, &status2, 0);
            printf("Soc altre fill (%d, fill de %d )\n", getpid(), getppid());
            break;
        }
        break;
    }
    return 0;
}

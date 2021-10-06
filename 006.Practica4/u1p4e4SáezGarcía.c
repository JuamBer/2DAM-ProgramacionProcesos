#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>

int main()
{
    pid_t pid;
    int status;
    int op;
    printf("Elije (1 o 2) para ajecutar primero ese proceso: ");
    scanf("%d", &op);
    pid = fork();

    switch (pid){
    case 1:
        printf("No s'ha pogut crear el procés fill\n");
        exit(1);
    case 0:
        if(op==2){
            wait(NULL);
            printf("Soc procés 1 i acabe\n");
        }else{
            printf("Soc procés 1 i acabe\n");
        }
        break;
    default:
        if (op==1)
        {
            wait(NULL);
            printf("Soc procés 2 i acabe\n");
        }else{
            printf("Soc procés 2 i acabe\n");
        }
        break;
    }
    return 0;
}

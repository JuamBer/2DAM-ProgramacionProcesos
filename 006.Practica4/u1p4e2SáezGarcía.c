#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>

int main()
{
	pid_t pid1,pid2,pid3;
	pid1 = fork();

	switch (pid1){
	case 1:
		printf("No s'ha pogut crear el procés fill\n");
		exit(1);
	case 0:
		printf("Soc fill (%d, fill de %d )\n", getpid(), getppid());
		break;
	default:
		pid2 = fork();
		switch (pid2){
		case 1:
			printf("No s'ha pogut crear el procés fill\n");
			exit(1);
		case 0:
			printf("Soc fill (%d, fill de %d )\n", getpid(), getppid());
			break;
		default:
			pid3 = fork();
			switch (pid3){
			case 1:
				printf("No s'ha pogut crear el procés fill\n");
				exit(1);
			case 0:
				printf("Soc fill (%d, fill de %d )\n", getpid(), getppid());
				break;
			default:
				wait(NULL);
				printf("Soc el pare (%d, fill de %d )\n", getpid(), getppid());
				break;
			}
			break;
		}
		break;
	}
	return 0;
}

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>

int main()
{
	pid_t pid;
	int status;
	pid = fork();

	switch(pid) {
		case 1: 
			printf("No s'ha pogut crear el procés fill\n");
			exit(1);
		case 0: 
			for (size_t i = 0; i < 10; i++)
			{
				printf("Soc el fill\n");
			}
			
			break;
		default: 
			
			for (size_t i = 0; i < 10; i++)
			{
				printf("Soc el pare\n");
			}
			wait(NULL);
			printf("El meu procés fill ja ha acabat\n");
		break;
	}
	return 0;
}

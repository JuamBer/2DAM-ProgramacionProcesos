#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main(int argc, char *argv[]){
	pid_t pid1, pid2;
	int status1, status2;
	pid1=fork();
	
	if ( pid1 == 0 ){ /* fill */
		printf("Soc el primer fill (%d, fill de %d )\n", getpid(), getppid());
	}	
	else{ /* pare */
		pid2=fork();
	
		if ( pid2 == 0 ){ /* segon fill */
			printf("Soc el segon fill (%d, fill de %d )\n", getpid(), getppid());
		}
		else{ 
			/* pare */
			/* Esperem al primer fill acabe, status 0*/
			waitpid(pid1, &status1, 0);
			/* Esperem al segon fill acabe, status 0 */
			waitpid(pid2, &status2, 0);
			printf("Soc el pare (%d, fill de %d)\n", getpid(), getppid());
		}
	}
return 0;
}

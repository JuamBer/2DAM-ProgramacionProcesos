#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>


int main(int argc, char *argv[]){
	pid_t pid1, pid2;
	int status1, status2;
	
	pid1=fork();
	
	if ( pid1== 0 ){ 
		
		pid2=fork();
		
		if ( pid2 == 0 ){ /* net */
			printf("Soc el net (%d, fill de %d )\n", getpid(), getppid());
		}else{ /* pare */
			waitpid(pid2, &status2, 0);
			printf("Soc el pare (%d, fill de %d)\n", getpid(), getppid());
		}
		
	}else{ /* avi */
		waitpid(pid1, &status1, 0);
		printf("Soc l'avi (%d, fill de %d )\n", getpid(), getppid());
	}
	return 0;
}

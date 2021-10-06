#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main(int argc, char *argv[]){
	pid_t pid1, pid2;
	int status1;
	pid1=fork();
	
	int a=6;
	if ( pid1 == 0 ){ /* fill */
		waitpid(pid1, &status1, 0);
		a=a-5;
		printf("Soc el fill (%d, fill de %d )\n", getpid(), getppid());
		printf("El valor de a es: %d \n", a);
	}	
	else{ /* pare */
		a=a+5;
		printf("Soc el pare (%d, fill de %d)\n", getpid(), getppid());
		printf("El valor de a es: %d \n", a);
	}
return 0;
}

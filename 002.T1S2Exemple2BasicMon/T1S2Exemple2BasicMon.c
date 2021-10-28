#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
int main(int argc, char *argv[]){
	
	pid_t pid;
	pid=fork();

	if ( pid == 0 ){
		
		printf("Soc el fill (%d, fill de %d)\n", getpid(), getppid());
		
	}else{ 
		
		printf("Soc el pare (%d, fill de %d)\n", getpid(), getppid());
		
	}
	return 0;

}

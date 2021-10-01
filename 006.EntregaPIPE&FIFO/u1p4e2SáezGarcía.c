#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>
#include <string.h>

int main(int argc, char *argv[])
{
	pid_t pid1, pid2;
	int status1, status2;
	int fd1[2], fd2[2];
	pipe(fd1);
	pipe(fd2);
	char salutacioAviPare[]="Salutacions del teu pare.\0";
	char salutacioPareNet[]="Salutacions del teu pare.\0";
	char salutacioNetPare[]="Salutacions del teu fill.\0";
	char salutaciolPareAvi[]="Salutacions del teu fill.\0";
	char buffersalutacioAviPare[strlen(salutacioAviPare)+1];
	char buffersalutacioPareNet[strlen(salutacioPareNet)+1];
	char buffersalutacioNetPare[strlen(salutacioNetPare)+1];
	char buffersalutacioPareAvi[strlen(salutaciolPareAvi)+1];
	pid1=fork();
	if ( pid1== 0 ) { /* PARE */
		pid2=fork();
		if ( pid2== 0 ) { /* NET */
			close (fd1[0]); // TANCA EL DESCRIPTOR D'ENTRADA fd1
			close (fd2[1]); // TANCA EL DESCRIPTOR D'EIXIDA fd2
			read (fd2[0],buffersalutacioPareNet, sizeof(buffersalutacioPareNet)); // LLIG EN EL PIPE
			printf("NET rep msg del PARE. %s\n", buffersalutacioPareNet);
			printf("NET envia msg al PARE.\n");
			write (fd1[1],salutacioNetPare, strlen(salutacioNetPare)+1); // ESCRIC EN EL PIPE
			printf("Soc el net (%d, fill de %d)\n", getpid(), getppid());
		}
		else { /* PARE */
			close (fd2[0]); // TANCA EL DESCRIPTOR D'ENTRADA fd2
			close (fd1[1]); // TANCA EL DESCRIPTOR D'EIXIDA fd1

			read (fd1[0],buffersalutacioAviPare, sizeof(buffersalutacioAviPare)); // LLIG EN EL PIPE
			printf("PARE rep msg de l'AVI. %s\n", buffersalutacioAviPare);
			printf("PARE envia msg al FILL.\n");
			write (fd2[1],salutacioPareNet, strlen(salutacioPareNet)+1); // ESCRIC EN EL PIPE
			read (fd1[0],buffersalutacioNetPare, sizeof(buffersalutacioNetPare)); // LLIG EN EL PIPE
			printf("PARE rep msg del NET. %s\n", buffersalutacioNetPare);
			printf("PARE envia msg a l'AVI.\n");
			write (fd2[1],salutaciolPareAvi, strlen(salutaciolPareAvi)+1); // ESCRIC EN EL PIPE

			waitpid(pid2, &status2, 0);
			printf("Soc el pare (%d, fill de %d)\n", getpid(), getppid());
		}
	}
	else { /* AVI */
		/* ESPEREM AL PARE (PARE DEL NET) ACABE, status 0 */
		close (fd1[0]); // TANCA EL DESCRIPTOR D'ENTRADA fd1
		close (fd2[1]); // TANCA EL DESCRIPTOR D'EIXIDA fd2
		printf("AVI envia msg al PARE\n");
		write (fd1[1],salutacioAviPare, strlen(salutacioAviPare)+1); // ESCRIC EN EL PIPE
		waitpid(pid1, &status1, 0);
		read (fd2[0],buffersalutacioPareAvi, sizeof(buffersalutacioPareAvi)); // LLIG EN EL PIPE
		printf("AVI rep msg del PARE. %s\n", buffersalutacioPareAvi);
		printf("Sóc l'avi (%d, fill de %d)\n",getpid(), getppid());
	}
	return 0;
}

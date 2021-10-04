#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>

int main(){
	int fp;
	char salutacio[] = "Salutacionsss!!!";
	fp=open("FIFO1",1);
	
	if(fp==-1){
		printf("Error");
		exit(1);
	}
	
	printf("Enviant la informació al FIFO\n");
	write(fp,salutacio,strlen(salutacio));
	close(fp);
	return 0;
}

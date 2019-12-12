/* CS360 Lab 4: C data types */

/* Manuel Larios, CS 360*/

#include <stdio.h>
#include <stdlib.h>

#define MIN_FILE_SIZE 1
#define MAX_FILE_SIZE 10485760
#define MEGABYTE 1048576

int initialize(int argc, char ** argv);
int readFile();

FILE * fp;

int main( int argc, char ** argv )
{
	initialize(argc, argv);
	readFile(fp);

	fclose(fp);				// close and free the file
	exit(EXIT_SUCCESS);		// or return 0;
}

int initialize(int argc, char ** argv)
{
	// Open the file given on the command line
	if( argc != 2 )
	{
		printf( "Usage: %s filename.mp3\n", argv[0] );
		return(EXIT_FAILURE);
	}
	
	fp = fopen(argv[1], "rb");
	if( fp == NULL )
	{
		printf( "Can't open file %s\n", argv[1] );
		return(EXIT_FAILURE);
	}
	return 0;
}

int readFile()
{
	// How many bytes are there in the file?  If you know the OS you're
	// on you can use a system API call to find out.  Here we use ANSI standard
	// function calls.
	double size = 0;
	fseek( fp, 0, SEEK_END );		// go to 0 bytes from the end
	size = ftell(fp);				// how far from the beginning?
	rewind(fp);						// go back to the beginning
	
	if( size < MIN_FILE_SIZE || size > MAX_FILE_SIZE )
	{
		printf("File size is not within the allowed range\n"); 
	}
	
	printf( "File size: %.2f MB\n", size/MEGABYTE );
	// Allocate memory on the heap for a copy of the file
	unsigned char * data = (unsigned char *)malloc(size);
	// Read it into our block of memory
	size_t bytesRead = fread( data, sizeof(unsigned char), size, fp );
	if( bytesRead != size )
	{
		printf( "Error reading file. Unexpected number of bytes read: %zu\n",bytesRead );
		free((unsigned char *) data);
	}

	// My attempt to try and read the MP3 header below
	// NOTE: We currently are not doing anything with the result[] char array.
	int i = 0;
	unsigned char result[32];
	while(i < size)
	{
		if((data[i] == 0xFF) && ((data[i+1] &0xF0) == 0xF0)){
			for(int j = 0; j < 8; ++j) {
				result[j] = *data << j;
			}
		}
		i++;
	}	

	return 0;
}
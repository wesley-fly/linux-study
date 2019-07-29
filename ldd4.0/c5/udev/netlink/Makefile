CC := gcc

netlink-op: netlink-op.o
	$(CC) -o netlink-op netlink-op.o

netlink-op.o:
	$(CC) -c netlink-op.c 

clean:
	rm *.o netlink-op

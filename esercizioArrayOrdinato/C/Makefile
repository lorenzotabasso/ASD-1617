

all: bin/ordered_array bin/ordered_array_tests

CFLAGS = -std=c99 -g -Wall -Wextra -pedantic -Wconversion
OBJECTS = build/ordered_array.o build/ordered_array_main.o build/ordered_array_tests.o build/unity.o
INCLUDES = src/*.h

COMMON_DEPS = $(BIN) $(BUILD) $(INCLUDES) Makefile

BIN = bin
BUILD = build

$(BIN):
	if [ ! -d "./$(BIN)" ];then     \
		mkdir $(BIN);           \
	fi

$(BUILD):
	if [ ! -d "./$(BUILD)" ];then     \
		mkdir $(BUILD);           \
	fi

build/%.o: src/%.c $(COMMON_DEPS)
	$(CC) $(CFLAGS) -c $< -o $@

bin/ordered_array: build/ordered_array.o build/ordered_array_main.o $(COMMON_DEPS)
	$(CC) -o bin/ordered_array build/ordered_array.o build/ordered_array_main.o

bin/ordered_array_tests: build/ordered_array_tests.o build/ordered_array.o build/unity.o $(COMMON_DEPS)
	$(CC) -o bin/ordered_array_tests  build/ordered_array_tests.o build/ordered_array.o build/unity.o

clean:
	rm -f build/* bin/*

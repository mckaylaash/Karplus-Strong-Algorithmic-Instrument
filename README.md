# Karplus-Strong-Algorithmic-Instrument
Uses the Karplus-Strong algorithm to simulate the plucking of a guitar string, implementing Ring Buffer and Guitar String objects.

**RingBuffer**
RingBuffer class implements cyclic wrap-around for an array of specified capacity, and allows for incrementing and removing of integer variables.

Method enqueue adds the specified item to the end of the ring buffer, and method dequeue removes the first item from the ring buffer.

Methods capacity and size return the specified capacity inputted when ring buffer was created, and the current number of items the ring holds. 

Method peek returns the item at the front of the ring buffer, *not necessarily at index 0*.

**GuitarString**
Overloaded capacitors, one that inputs frequency and creates a string of that specified frequency. The other takes a double array whose initial values are given in the array, and whose size is given by the length of that array.

Method pluck simulates the plucking of a guitar string and replaces the ring buffer with white noise.

Method tic increments a single step using the Karplus-Strong algorithm.

**GuitarHero**
Supports 37 notes on the chromatic scale from 110 Hz to 880 Hz. Notes can be played using a computer keyboard. White keys are on the qwerty and zxcv rows and black are on the 12345 and asdf rows. 

Only implemented using the main method.

Mine Sweeper Game
=================
It has got 3 functionalities

Configure Game
--------------
Provides a way to <i class="icon-cog"></i> configure (Which location is explosive and which one is safe) the game, before the play.

Open
-----
Opens a position, game would be over if you open an explosive location

Flag
----
Flaps a postion, game woulod be over if you flag a safe location

``` 
Opening explosive location
--------------

Game Initilized
XXX
XXX
XXX
Game Over!!! You have blown explosive!!

```

``` 
Game Moves
--------------
Game Initilized
XXX
XXX
XXX
Invalid Position(3, 3)
Flagging Position(0, 0)
FXX
XXX
XXX
Opening Position(0, 1)
FOX
XXX
XXX
Opening Position(0, 2)
FOO
XXX
XXX
Flagging Position(1, 0)
FOO
FXX
XXX
Opening Position(2, 2)
FOO
FXX
XXO
Opening Position(2, 1)
FOO
FXX
XOO
Flagging Position(2, 0)
FOO
FXX
FOO
Opening Position(1, 2)
FOO
FXO
FOO
Opening Position(1, 1)
FOO
FOO
FOO
```
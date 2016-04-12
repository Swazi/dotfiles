import time
#import stddraw
import os

ALIVE = '*'
DEAD = '.'

def read_to_2d_array(filename):
	file = open(filename, "r")
	return [list(line.rstrip()) for line in file]
		
def is_alive(cell):
	return cell == ALIVE
	
def evolve(game, x, y):
	cell = game[x][y]
	neighbors = get_neighbors(game, x, y)
	living_neighbors = len([x for x in neighbors if is_alive(x)])
	if is_alive(cell):
		if (living_neighbors == 2 or living_neighbors == 3):
			return ALIVE
		else:
			return DEAD
	else:
		if living_neighbors == 3:
			return ALIVE
		else:
			return DEAD

def evolve_all(game):
	y_bound = len(game)
	x_bound = len(game[0])
	evolved_game = [['' for x in range(x_bound)] for y in range(y_bound)]
	for y in range(y_bound):
		for x in range(x_bound):
			evolved_game[x][y] = evolve(game, x, y)
	return evolved_game
	
def get_neighbors(game, x, y):
	neighbors = []
	try:
		neighbors.append(game[x-1][y])
	except IndexError:
		pass
	try:
		neighbors.append(game[x][y-1])
	except IndexError:
		pass
	try:
		neighbors.append(game[x+1][y])
	except IndexError:
		pass
	try:
		neighbors.append(game[x][y+1])
	except IndexError:
		pass
	try:
		neighbors.append(game[x+1][y+1])
	except IndexError:
		pass
	try:
		neighbors.append(game[x+1][y-1])
	except IndexError:
		pass
	try:
		neighbors.append(game[x-1][y+1])
	except IndexError:
		pass
	try:
		neighbors.append(game[x-1][y-1])
	except IndexError:
		pass
		
	return neighbors
		
def print_game(game):
	for row in game:
		print ''.join(row)
		print '\n'

def draw_game(picture, game):
	grey = pict.color(84, 84, 84)
	red = pict.color(255, 0 , 0)
	x = 1/37
	y = 1/37
	iterate = 1/37
	for row in game:
		for cell in row:
			if is_alive(cell):
				picture.square(x, y, iterate, red)
			else:
				picture.square(x, y, iterate, grey)
				

		
def main():
	game = read_to_2d_array("V:/BGA/Shared/suaral/Test/8/one.txt")

	print_game(game)
	start_time = time.time()
	interval = 1
	for i in range(20):
		time.sleep(start_time + i*interval - time.time())
		game = evolve_all(game)
		print_game(game)
		
if __name__ == "__main__":
    main()

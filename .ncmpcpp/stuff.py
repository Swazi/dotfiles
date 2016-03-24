def problem_1(dict):
	#1
	largest = max([len(x) for x in dict.values()])
	print "#1:\n\t", largest
	
	#2
	print "#2:\n\t", [x for x in dict.keys() if len(dict[x]) == largest]
	
	#3
	print "#3:\n\t", len(dict.keys())
 
	#4
	smallest = min([len(x) for x in dict.values()])
	print "#4:\n\t", smallest
	print "\t", [x for x in dict.keys() if len(dict[x]) == smallest]
	
	#5
	print "#5:\n\t",[x for x in dict.keys() if "Owen Wilson" in dict[x]]
	
	#6
	print "#6:\n\t",[x for x in dict["Silver Linings Playbook"] if x in dict["American Hustle"]]
	
def problem_2(dict):
	#7
	print "#7:\n\t", dict["Owen Wilson"]
	
	#8
	print "#8:\n\t", len(dict.keys())
	
	#9
	largest = max(len(films) for films in dict.values())
	print "#9:\n\t", [x for x in dict.keys() if len(dict[x]) == largest]
	
	#10
	print "#10:\n\t", list(set(dict["Clint Eastwood"] + dict["Morgan Freeman"]))
	
def problem_3(dict):
	#11
	largest = max(len(x) for x in dict.values())
	print "#11:\n\t", [x for x in dict.keys() if len(dict[x]) == largest]
	
	#12
	print "#12:\n\t", "Kate Winslet" in dict["Cate Blanchett"]
	
	#13
	print "#13:\n\t", "Kate Winslet" in [x for sublist in [dict[x] for x in dict["Cate Blanchett"]] for x in sublist]
	
def problem_4(tree, actors_film):
	print "#14:\n\t"
	print "\t", path_to_person(tree, "Cate Blanchett")
	print "\t", path_to_person(tree, "Adam Sandler")
	print "\t", path_to_person(tree, "Kate Winslet")
	print "\t", path_to_person(tree, "Morgan Freeman")
	
	print "#15:\n\t", (len(tree.keys()) * 1.0 / len(actors_film.keys())) * 100, "%"
	
	print "#16:\n\t", 7
	
	print "#17:\n\t"
	for actor in tree.keys():
		path = path_to_person(tree, actor)
		if len(path) == 7:
			print "\t", path
			break
		
def imp_path_to_person(tree, person):
	path = []
	
	while person != "":
		path.append(person)
		values = tree[person]
		if values == "":
			break
		person = values[0]
		films = values[1]
		path.append(films)
	return path

def path_to_person(tree, person):
	path = []
	while person != "":
		path.append(person)
		person = tree[person]
	return path
	
def get_collaborations(actor_films, actor_1, actor_2):
	return [x for x in actor_films[actor_1] if x in actor_films[actor_2]]

def make_film_actors_dictionary():
  titledict = {}
  infile = open("V:/BGA/Shared/suaral/Test/mdb.txt", "r")
  masterlist = [nextline.strip() for nextline in infile]
  infile.close()
  j = 0
  while j < len(masterlist):
    title = masterlist[j]
    actor = masterlist[j + 1]
    if title in titledict:
      if not actor in titledict[title]:
        titledict[title].append(actor)
    else:
      titledict[title] = [actor]
    j = j + 2
  return titledict
	
def make_actor_films_map(dict):
	actordict = {}
	for film, cast in dict.iteritems():
		for actor in cast:
			actordict[actor] = actordict.get(actor, [])
			if film not in actordict[actor]:
				actordict[actor].append(film)
	return actordict
	
def make_collaboration_graph(actor_films, film_actors):
	collab = {}
	for actor in actor_films.keys():
		for film in actor_films[actor]:
			for collaborator in film_actors[film]:
				if actor != collaborator and collaborator not in collab:
					collab[collaborator] = [actor]
				else:
					collab.get(collaborator, []).append(actor)
	return collab	

def make_bfs_tree(g, root):
	tree = {root: ""}
	current_level = [root]
	depth = 0
	while current_level:
		new_level = []
		for actor in current_level:
			for collaborator in g[actor]:
				if collaborator not in tree:
					tree[collaborator] = actor
					new_level.append(collaborator)
		current_level = new_level
		depth += 1
	print "Depth:", depth
	return tree
	
def make_improved_bfs_tree(g, actor_films, start, destination):
	tree = {start: ""}
	current_level = [start]
	while current_level:
		new_level = []
		for actor in current_level:
			for collaborator in g[actor]:
				if collaborator not in tree:
					tree[collaborator] = (actor, get_collaborations(actor_films, actor, collaborator))
					new_level.append(collaborator)
		current_level = new_level
	return tree

 
def main():
	film_actors = make_film_actors_dictionary()
	problem_1(film_actors)
	
	actor_films = make_actor_films_map(film_actors)
	problem_2(actor_films)
	
	collab_map = make_collaboration_graph(actor_films, film_actors)
	problem_3(collab_map)
	
	tree = make_bfs_tree(collab_map, "Dustin Hoffman")
	problem_4(tree, actor_films)
	
	imp_tree = make_improved_bfs_tree(collab_map, actor_films, "Don Cheadle", "Meryl Streep")
	print "#18\n\t", imp_path_to_person(imp_tree, "Meryl Streep")
	
if __name__ == "__main__":
    main()

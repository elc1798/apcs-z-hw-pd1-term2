f = open("MAZE4.dat");
DATA = f.read().replace("+" , "#").replace("-" , "#").replace("|" , "#")
f.close()
g = open("Processed.dat" , 'w');
g.write(DATA)
g.close()

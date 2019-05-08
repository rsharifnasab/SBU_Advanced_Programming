from matplotlib import pyplot as plt

db = []
T = 100
TedadElement = 520
toolZel = 1
kolQ = 1
K = 1/(4 * 3.1415926 * 8.85*10**(-12) )

for r in range(T):
    E = 0
    fasele = 1 + r /10

    for i in range(TedadElement):
        for j in range(TedadElement):
            #UP
            dist = fasele**2
            dist += ((TedadElement/2 - i)*toolZel )**2
            dist += ((TedadElement/2 - i)*toolZel )**2
            ssin = fasele  / (dist**0.5)
            E += K * kolQ * ssin / (TedadElement**2) /dist 
            #DOWN
            dist = (fasele+toolZel)**2
            dist += ((TedadElement/2 - i)*toolZel )**2
            dist += ((TedadElement/2 - i)*toolZel )**2
            ssin = fasele / (dist **0.5)
            E += K * kolQ * ssin / (TedadElement**2) /dist 
            #ZEL
            #TODO
    print(r," : ",E)
    db.append(E)
plt.bar(range(T),db)
plt.show()
        
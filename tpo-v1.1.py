k = 8
ji = 1
jg = 6
etapa = 0
sol = []

def moverIzq(posiciones, jugadores, ji):
    i = 0
    j = ji
    while  i < posiciones:
        j -= 1
        if j < 0:
            j = len(jugadores) - 1
        if jugadores[j] != -1:
            i += 1
    return j

def moverDer(posiciones, jugadores, ji):
    i = 0
    j = ji
    while  i < posiciones:
        j += 1
        if j > len(jugadores) - 1:
            j = 0
        if jugadores[j] != -1:
            i += 1
    return j

def jugar(jugadores, ji, jg, k, e, solucion):
    if len(jugadores) == e:
        if jugadores[ji] == jg:
            return True
        else:
            return False
    else:
        e += 1
        nextPos = moverIzq(k + 1, jugadores, ji)
        toCheck = jugadores[nextPos]
        if toCheck == jg: # Poda
            return False
        jugadores[nextPos] = -1
        solucion.append("Izquierda " + str(toCheck))
        resIzq = jugar(jugadores, moverIzq(1, jugadores, nextPos), jg, k, e, solucion)
        if resIzq:
            return solucion
        jugadores[nextPos] = toCheck
        solucion.pop()

        nextPos = moverDer(k + 1, jugadores, ji)
        toCheck = jugadores[nextPos]
        if toCheck == jg: # Poda
            return False
        jugadores[nextPos] = -1
        solucion.append("Derecha " + str(toCheck))
        resDer = jugar(jugadores, moverDer(1, jugadores, nextPos), jg, k, e, solucion)
        if resDer:
            return solucion
        jugadores[nextPos] = toCheck
        solucion.pop()

for i in range(1, k + 1):
    jugadores = [0, 1, 2, 3, 4, 5, 6, 7, 8]
    res = jugar(jugadores, ji, jg, i, 1, [])
    if res:
        print("Solucion para k = ", i, " es: ", res)
    else:
        print("No hay solucion para k = ", i)

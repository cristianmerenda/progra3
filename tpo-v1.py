jugadores = [0, 1, 2, 3]
k = 3
ji = 2
jg = 0
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
    if len(jugadores) - 1 == e:
        if jugadores[ji] == jg:
            return True
        else:
            return False
    else:
        nextPos = moverIzq(k + 1, jugadores, ji)
        toCheck = jugadores[nextPos]
        jugadores[nextPos] = -1
        solucion.append("Izquierda " + str(toCheck))
        resIzq = jugar(jugadores, moverIzq(1, jugadores, nextPos), jg, k, e + 1, solucion)
        if resIzq:
             print(solucion)
             quit()
        jugadores[nextPos] = toCheck
        solucion.pop()

        e -= 1
        nextPos = moverDer(k + 1, jugadores, ji)
        toCheck = jugadores[nextPos]
        jugadores[nextPos] = -1
        solucion.append("Derecha " + str(toCheck))
        resDer = jugar(jugadores, moverDer(1, jugadores, nextPos), jg, k, e + 1, solucion)
        if resDer:
             print(solucion)
             quit()
        jugadores[nextPos] = toCheck
        solucion.pop()
        e -= 1

jugar(jugadores, ji, jg, 2, 1, [])

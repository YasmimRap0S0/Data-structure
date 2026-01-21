import math

def introsort(arr):
    ## Calcula o limite máximo de profundidade permitido para o Quicksort
    max_profundidade = 2 * math.floor(math.log2(len(arr)))
    introsort_aux(arr, 0, len(arr) - 1, max_profundidade)

def introsort_aux(arr, inicio, fim, max_profundidade):
    ## Se o subarray for pequeno, usa Insertion Sort
    if fim - inicio <= 16:
        ordenacao_insercao(arr, inicio, fim)
    ## Se atingir o limite de profundidade, troca para HeapSort
    elif max_profundidade == 0:
        ordenacao_heap(arr, inicio, fim)
    else:
        ## Caso normal: usa Quicksort
        pivo = particao(arr, inicio, fim)
        introsort_aux(arr, inicio, pivo - 1, max_profundidade - 1)
        introsort_aux(arr, pivo + 1, fim, max_profundidade - 1)

# Funções auxiliares

def ordenacao_insercao(arr, inicio, fim):
    ## Ordena subarrays pequenos com Insertion Sort
    for i in range(inicio + 1, fim + 1):
        chave = arr[i]
        j = i - 1
        while j >= inicio and arr[j] > chave:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = chave

def particao(arr, baixo, alto):
    ## Divide o array em torno de um pivô (Quicksort)
    pivo = arr[alto]
    i = baixo - 1
    for j in range(baixo, alto):
        if arr[j] <= pivo:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[alto] = arr[alto], arr[i + 1]
    return i + 1

def ordenacao_heap(arr, inicio, fim):
    ## Usa HeapSort como fallback
    subarr = arr[inicio:fim + 1]
    construir_heap(subarr)
    for i in range(len(subarr) - 1, 0, -1):
        subarr[0], subarr[i] = subarr[i], subarr[0]
        max_heapify(subarr, 0, i)
    arr[inicio:fim + 1] = subarr

def construir_heap(arr):
    ## Constrói um max-heap
    for i in range(len(arr) // 2 - 1, -1, -1):
        max_heapify(arr, i, len(arr))

def max_heapify(arr, indice, tamanho):
    ## Garante a propriedade de max-heap
    maior = indice
    esquerda = 2 * indice + 1
    direita = 2 * indice + 2

    if esquerda < tamanho and arr[esquerda] > arr[maior]:
        maior = esquerda
    if direita < tamanho and arr[direita] > arr[maior]:
        maior = direita
    if maior != indice:
        arr[indice], arr[maior] = arr[maior], arr[indice]
        max_heapify(arr, maior, tamanho)

arr = [10, -3, 5, 7, -8, 4]
print("Array original:", arr)
introsort(arr)
print("Array ordenado:", arr)

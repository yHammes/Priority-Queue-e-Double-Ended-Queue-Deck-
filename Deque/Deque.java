package Deque;

public class Deque {
    Node head;
    Node tail;
    int size;

    // Cria uma Deque vazia
    public Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Insere um novo elemento no início da Deque
    public void insertFirst(int value) {
        Node current = new Node(value);

        // Caso a Deque esteja vazia, o novo nó será head e tail
        if (head == null) {
            head = current;
            tail = current;
            size++;
        } else {
            // Conecta o novo nó ao antigo head
            current.next = head;
            head.previous = current;

            // Atualiza o head
            head = current;
            size++;
        }
    }

    // Insere um novo elemento no final da Deque
    public void insertLast(int value) {
        Node current = new Node(value);

        // Caso a Deque esteja vazia, o novo nó será head e tail
        if (head == null) {
            head = current;
            tail = current;
            size++;
        } else {
            // Conecta o novo nó ao antigo tail
            current.previous = tail;
            tail.next = current;

            // Atualiza o tail
            tail = current;
            size++;
        }
    }

    // Remove o primeiro elemento da Deque
    public boolean deleteFirst() {

        // Não é possível remover se a Deque estiver vazia
        if (head == null) {
            return false;
        }

        // Caso exista apenas um elemento
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return true;
        }

        // O próximo elemento passa a ser o novo head
        head = head.next;
        head.previous = null;

        size--;
        return true;
    }

    // Remove o último elemento da Deque
    public boolean deleteLast() {

        // Não é possível remover se a Deque estiver vazia
        if (tail == null) {
            return false;
        }

        // Caso exista apenas um elemento
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return true;
        }

        // O elemento anterior passa a ser o novo tail
        tail = tail.previous;
        tail.next = null;

        size--;
        return true;
    }

    // Procura um valor na Deque
    public boolean search(int value) {
        Node current = head;

        // A Deque está vazia
        if (head == null) {
            return false;
        }

        // Percorre a Deque procurando o valor
        while (current != null) {
            if (current.value == value) {
                return true;
            }

            current = current.next;
        }

        // O valor não foi encontrado
        return false;
    }

    // Verifica se a Deque está vazia
    public boolean isEmpty() {
        return head == null;
    }

    // Retorna a quantidade de elementos da Deque
    public int getSize() {
        return size;
    }

    // Imprime os elementos da Deque do início para o final
    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.value + ",");

            current = current.next;
        }
    }
}
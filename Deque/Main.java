package Deque;

public class Main {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("       TESTE DA DEQUE");
        System.out.println("================================");

        Deque list = new Deque();

        // Testando as inserções
        System.out.println("\n--- Inserindo elementos ---");

        list.insertFirst(4);
        list.insertFirst(7);
        list.insertFirst(1);
        list.insertLast(6);

        System.out.print("Lista atual: ");
        list.printList();

        System.out.println("\nTamanho: " + list.getSize());
        System.out.println("Head: " + list.head.value);
        System.out.println("Tail: " + list.tail.value);

        // Testando busca
        System.out.println("\n--- Testando busca ---");

        System.out.println("Busca 7: " + list.search(7));
        System.out.println("Busca 100: " + list.search(100));

        // Testando remoções
        System.out.println("\n--- Removendo elementos ---");

        System.out.println("Remove First: " + list.deleteFirst());
        System.out.println("Remove Last: " + list.deleteLast());

        System.out.print("Lista após as remoções: ");
        list.printList();

        System.out.println("\nTamanho: " + list.getSize());
        System.out.println("Head: " + list.head.value);
        System.out.println("Tail: " + list.tail.value);

        // Testando se está vazia
        System.out.println("\n--- Testando Deque vazia ---");

        System.out.println("A Deque está vazia? " + list.isEmpty());

        System.out.println("\n================================");
        System.out.println("          FIM DOS TESTES");
        System.out.println("================================");
    }
}
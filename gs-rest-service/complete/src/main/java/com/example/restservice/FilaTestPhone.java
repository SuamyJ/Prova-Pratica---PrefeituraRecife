public class FilaTestPhone {

    public static void main(String[] args) {

        // número de clientes na fila
        int M = 5;

        // números recebidos via SMS de cada cliente
        int[] smsNumbers = {4, 1, 5, 2, 3};

        // criar lista de clientes com seus números
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            customers.add(new Customer(i + 1, smsNumbers[i]));
        }

        // ordenar Pessoas com base nos números recebidos via SMS
        Collections.sort(customers);

        // verificar quantos Pessoas não precisaram mudar de posição na fila
        int unchanged = 0;
        for (int i = 0; i < M; i++) {
            if (customers.get(i).getId() == i + 1) {
                unchanged++;
            }
        }

        // imprimir lista de Pessoas e suas posições na fila
        System.out.println("Lista de Pessoas:");
        for (Customer c : customers) {
            System.out.println("Pessoa " + c.getId() + ": posição " + (c.getPosition() + 1));
        }

        // imprimir número de Pessoas que não precisaram mudar de posição
        System.out.println("Pessoas sem mudança de posição: " + unchanged);
    }
}

class Customer implements Comparable<Customer> {

    private int id;
    private int smsNumber;
    private int position;

    public Customer(int id, int smsNumber) {
        this.id = id;
        this.smsNumber = smsNumber;
    }

    public int getId() {
        return id;
    }

    public int getSmsNumber() {
        return smsNumber;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int compareTo(Customer c) {
        return Integer.compare(this.smsNumber, c.getSmsNumber());
    }
}
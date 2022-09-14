package recordLakes;
import java.util.Scanner;
class Lake{
    public int length;
    String name, location;		//name and location of the lake
    double square; 	//lake square
}

public class RecordLakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
// Input information about lakes
        System.out.println("������ ������� ���� => ");
        int n = sc.nextInt();    //number of lakes
        Lake[] lakes = new Lake[n];
        System.out.println("������ ���������� ��� �����: ");
        for (int i = 0; i < lakes.length; i++) {
            sc.nextLine();    //clearing the buffer
            lakes[i] = new Lake();
            System.out.print("����� " + (i + 1) + "-�� ����� => ");
            lakes[i].name = sc.nextLine();
            System.out.print("����� ������������ " + (i + 1) + "-�� ����� => ");
            lakes[i].location = sc.nextLine();
            System.out.print("����� " + (i + 1) + "-�� ����� => ");
            lakes[i].square = sc.nextDouble();
        }

//Output of received information
        System.out.println("\n���������� ��� �����: \n�����    �����    �����");
        for (Lake l : lakes)
            System.out.println( l.name + "\t" + l.location + " " + "\t" + l.square + " ��. ��");

//The lake with the largest square
 int indMax = 0;    //element number for the country with the maximum area (initial value)
      double max = lakes[indMax].square; //maximum square (initial value)
        for (int i = 0; i < lakes.length; i++)
            if (lakes[i].square > max) {
                max = lakes[i].square;
                indMax = i;
            }
        System.out.println("\n����� � ��������� ������ :");
        System.out.println( lakes[indMax].name + "\t" + lakes[indMax].square + " ��. ��");

//The square is less than average
        double s=0;	//total square
        for (int i = 0; i < lakes.length; i++)
            s+=lakes[i].square;
        double sr = s/lakes.length; 	//average square
        System.out.printf("\n������� ����� = %.2f",sr);
        int numLakes = 0;
        System.out.println("�����, ����� ���� ����� ��������: ");
        for (int i = 0; i < lakes.length; i++) {
            if (lakes[i].square<sr) {numLakes ++;
            System.out.println( lakes[i].name );}
        } System.out.println("ʳ������ ����, � ������ ����� ��������: " + numLakes);

//Sorting the list of lakes by name
        for (int i = 0; i < lakes.length-1; i++)
            for (int j = 0; j < lakes.length-i-1; j++)
                if(lakes[j].name.compareTo(lakes[j+1].name)>0) {
                    Lake rem = lakes[j];	//rem � variable for permutation
                    lakes[j] = lakes[j + 1];
                    lakes[j + 1] = rem;
                }
        System.out.println("\n³����������� ������ �� ������:");
        for (int i = 0; i < lakes.length; i++) {
            System.out.println(""+lakes[i].name +"\t"+lakes[i].location+"\t"+lakes[i].square + " ��. ��");
        }

//Searching for a lake by name
        sc.nextLine();
        System.out.println("\n������ ����� �������� �����: ");
        String name=sc.nextLine();
        int nom= -1;
        for (int i = 0; i < lakes.length; i++)
            if (name.equalsIgnoreCase(lakes[i].name)) nom=i;

        if (nom != -1) {
            System.out.println("���� ����� � � ������. �������� ����������: "
                    + lakes[nom].name+" "+lakes[nom].location+" "+lakes[nom].square+" ��. ��");
        }else System.out.println("������ ����� ���� � ������");

//Request about which lake to change information
        System.out.println("\n������ ����� �����, ��� ��� ������ ������ ����������: ");
        String lName=sc.nextLine();
        int lNom= -1;
        for (int i = 0; i < lakes.length; i++)
            if (lName.equalsIgnoreCase(lakes[i].name)) lNom=i;
        if (lNom != -1) {
            System.out.println("���� ����� � � ������. �������� ����������: "
                    + lakes[lNom].name+" "+lakes[lNom].location+" "+lakes[lNom].square+" ��. ��");
            System.out.println("������ ���� ���������� ��� �����: ");
            Lake newLakes = new Lake(); //Filling in new information
                System.out.print("����� ����� => ");
            newLakes.name = sc.nextLine();
                System.out.print("����� ������������ ����� => ");
                newLakes.location = sc.nextLine();
                System.out.print("����� ����� => ");
                newLakes.square = sc.nextDouble();
            System.out.println("\n�������� ���������� ��� ����� �� ������: "
                    +"\n"+ newLakes.name+" "+newLakes.location+" "+newLakes.square+" ��. ��");
    }else System.out.println("������ ����� ���� � ������");
    }
}






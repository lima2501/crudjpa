package crudjpa;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		UserDAO dao = new UserDAO();

		System.out.println("Escolha umas das opções abaixo:" + "\n 1 => Cadastrar usuário"
				+ "\n 2 => Visualizar todos usuários" + "\n 3 => Buscar usuário por id: "
				+ "\n 4 => Atualizar usuário por id" + "\n 5 => Deletar usuário");
		int op = scan.nextInt();
		scan.nextLine();

		if (op == 1) {

			System.out.print("Entre com o nome do usuário: ");
			String name = scan.nextLine();
			System.out.print("Entre com o email do usuário: ");
			String email = scan.nextLine();

			User user = new User(name, email);
			dao.create(user);
		} else if (op == 2) {
			var query = dao.readAll();
			query.setMaxResults(7);
			List<User> users = query.getResultList();

			for (User u : users) {
				System.out.println(u);
			}
		} else if (op == 3) {
			System.out.print("Entre com o número de id: ");
			int id = scan.nextInt();
			var user = dao.readByid(id);
			System.out.println(user);
		} else if (op == 4) {
			System.out.print("Entre com o número de id: ");
			int id = scan.nextInt();
			scan.nextLine();
			System.out.print("Novo nome: ");
			String name = scan.nextLine();
			System.out.print("Novo email: ");
			String email = scan.nextLine();
			User user = new User(name, email);
			dao.updateById(user, id);
		} else if (op == 5) {
			System.out.print("Entre com o número de id: ");
			int id = scan.nextInt();
			dao.delete(id);
		}

		scan.close();
	}
}

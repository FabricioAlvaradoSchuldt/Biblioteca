package biblioteca.model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.List;

public class Serializzatore {

	public static <E> void serialize(E x, String nomefile) {

		List<E> lista = new ArrayList<E>();

		lista.add(x);

		serialize(lista, nomefile);

	}

	public static <E> void serialize(List<E> lista, String nomefile) {

		try {
			FileOutputStream file = new FileOutputStream(nomefile);
			ObjectOutputStream obj = new ObjectOutputStream(file);

			for (E x : lista) {
				obj.writeObject(x);

			}

			obj.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public static <E> List<E> deserialize(String nomefile) {

		List<E> lista = new ArrayList<E>();

		try {
			FileInputStream file = new FileInputStream(nomefile);
			ObjectInputStream obj = new ObjectInputStream(file);

			try {
				while (true) {
					lista.add((E) obj.readObject());
				}
			} catch (EOFException e) {

			}

			obj.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;

	}

}

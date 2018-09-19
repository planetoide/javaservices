package services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProductoDao {
	public void addProduct(Producto producto) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
	
	/*
	 * Método para eliminar un producto mediante el id*/
    public void deleteProduct(int productoid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Producto producto = (Producto) session.load(Producto.class, new Integer(productoid));
            session.delete(producto);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    /*
     * Método para actualizar un producto
     * */
    public void updateProduct(Producto producto) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(producto);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    /*
     * Método para mostrar todos los prodctos registrados en la base de datos
     * */
    public List<Producto> getAllProducts() {
        List<Producto> productos = new ArrayList<Producto>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            productos = session.createQuery("from services.Producto").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return productos;
    }

    /*
     * Método para retornar los datos de un producto en específico
     * */
    public Producto getProductById(int productoid) {
        Producto producto = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from services.Producto where id = :id";
            Query query = session.createQuery(queryString);
            query.setParameter("id", productoid);
            producto = (Producto) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return producto;
    }
}

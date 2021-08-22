package repository;

import model.Diretor;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiretorRepository implements IRepository {
    @Override
    public List<Diretor> findAll() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement =conn.prepareStatement("select * from curso.diretor");
        ResultSet resultSet=null;
        resultSet =  statement.executeQuery();

        List<Diretor> diretor =new ArrayList<>();
        System.out.println("---------Busca----------------");
        while(resultSet.next()){
            String index = resultSet.getString(2);
            System.out.println(index);
        }
        System.out.println("---------Fim Busca------------");
        conn.close();

        return diretor;
    }

    @Override
    public Object findById(Integer id) throws SQLException, ClassNotFoundException {
        Connection conn =ConnectionManager.getConnection();
        PreparedStatement statement1= conn.prepareStatement("select * from curso.diretor where id=?");
        statement1.setInt(1,id);
        ResultSet resultSet1=null;
        resultSet1= statement1.executeQuery();

        System.out.println("--------Busca por ID-------");
        while (resultSet1.next()){
            String index = resultSet1.getString(2);
            System.out.println(index);
        }
        System.out.println("--------FIm Busca ID---------");
        conn.close();

        return new Diretor();
    }
}

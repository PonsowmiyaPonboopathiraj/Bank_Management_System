package repository.Implementation;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import enums.AccountQuery;
import exceptions.NotFoundException;
import models.Account;
import models.AccountType;
import models.Branch;
import models.Customer;

import repository.RepoInterface;

public class AccountRepo implements RepoInterface{

    @Override
    public void loadAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadAll'");
    }

    @Override
    public List getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public void add(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public void syncChanges() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'syncChanges'");
    }
    
}

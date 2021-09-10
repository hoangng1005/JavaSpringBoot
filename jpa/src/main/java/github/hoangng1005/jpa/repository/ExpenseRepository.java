package github.hoangng1005.jpa.repository;

import github.hoangng1005.jpa.model.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    public List<Expense> findByItem(String item);
    @Query("SELECT e FROM Expense e WHERE e.amount >= :amount")
    public List<Expense> listItemWithPriceOver(@Param("amount") float amount);
}

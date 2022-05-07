package SharedKernel.db;

import java.util.List;

public interface IDbContext extends IDbSet {
    public void Transaction();

    public void Commit();

    public void Rollback();

    public boolean isConnected();

    public void onModelCreating(List<DbSet> sets);

}

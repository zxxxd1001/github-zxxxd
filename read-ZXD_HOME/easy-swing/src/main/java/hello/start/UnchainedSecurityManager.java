package hello.start;

import java.security.Permission;


public class UnchainedSecurityManager extends SecurityManager
{

    public void checkPermission(Permission perm)
    {
        check(perm);
    }


    public void checkPermission(Permission perm, Object context)
    {
        check(perm);
    }

    private void check(Permission perm)
    {
        return;
    }
}


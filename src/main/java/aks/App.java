package aks;

import aks.auth.Authenticate;
import aks.crypto.GET.AvailableCrypto;
import aks.crypto.POST.SelectItem;
import aks.goods.TestClassItems;
import aks.profile.User;

public class App {
    public Utilities utils = new Utilities();
    User user = new User();
    Authenticate authenticate = new Authenticate(user);
    AvailableCrypto availableCrypto = new AvailableCrypto(this);
    TestClassItems testClassItems = new TestClassItems();
    SelectItem selectItem = new SelectItem(this);
}

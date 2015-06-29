package ciriti.retrofitmockserver.component;

import ciriti.retrofitmockserver.activity.MainActivity;
import ciriti.retrofitmockserver.fragment.FragUsers;

/**
 * Created by ciriti on 29/06/15.
 */
public interface ParentApiComponent {
    void inject(MainActivity mainActivity);
    void inject(FragUsers fragUsers);
}

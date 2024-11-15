package w10.generics.mgr;

public interface Factory<T extends Manageable> {
	T create();
}

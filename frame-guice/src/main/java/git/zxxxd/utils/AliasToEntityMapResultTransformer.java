package git.zxxxd.utils;

import org.hibernate.transform.AliasedTupleSubsetResultTransformer;

import java.util.HashMap;
import java.util.Map;

public class AliasToEntityMapResultTransformer extends AliasedTupleSubsetResultTransformer {

    public static final AliasToEntityMapResultTransformer INSTANCE = new AliasToEntityMapResultTransformer();
    public Map<String, String> aliasMap = new HashMap<String, String>();

    /**
     * Disallow instantiation of AliasToEntityMapResultTransformer.
     */
    private AliasToEntityMapResultTransformer() {
    }

    /**
     * {@inheritDoc}
     */
    public Object transformTuple(Object[] tuple, String[] aliases) {
        Map result = new HashMap(tuple.length);
        for ( int i=0; i<tuple.length; i++ ) {
            String alias = aliases[i];
            if ( alias!=null ) {
                if (!aliasMap.containsKey(alias)) {
                    aliasMap.put(alias, StringUtils.toHumpName(alias));
                }
                result.put(aliasMap.get(alias), tuple[i] );
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isTransformedValueATupleElement(String[] aliases, int tupleLength) {
        return false;
    }

    /**
     * Serialization hook for ensuring singleton uniqueing.
     *
     * @return The singleton instance : {@link #INSTANCE}
     */
    private Object readResolve() {
        return INSTANCE;
    }
}

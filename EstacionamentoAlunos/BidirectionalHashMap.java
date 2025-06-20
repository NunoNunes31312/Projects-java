import java.util.HashMap; //Dica

/**
 * Tabela bidirecional.
 */
public class BidirectionalHashMap<K, V> {
    
    private HashMap<K,V> map;
    private HashMap<V,K> reverseMap;
    
    private int size;

    /**
     * Construtor
     */
    public BidirectionalHashMap() {
        map = new HashMap<>();
        reverseMap = new HashMap<>();
        
        size=0;
    }

    /**
     * Dado um valor, obter a chave correspondente
     * @param value - o valor
     * @return K - a chave
     */
    public K getKey(V value) {
        
        return reverseMap.get(value);
    }

    /**
     * Dada uma chave, obter o valor correspondente
     * @param key - a chave
     * @return V - o valor
     */
    public V getValue(K key) {
        
        return map.get(key);
    }

    /**
     * Adicionar um par chave-valor
     * @param key - a chave
     * @param value - o valor
     */
    public void put(K key, V value) {
        if(reverseMap.containsKey(map.get(key))) {
            V oldValue = map.get(key);
            reverseMap.remove(oldValue);
        }
        
        if(map.containsKey(key)) {
            map.remove(key);
        }
        
        map.put(key, value);
        reverseMap.put(value, key);
        
    
        
        
    }

    /**
     * Verificar se a tabela contem uma dada chave
     * @param key - a chave
     * @return true se contem a chave, false caso contrario
     */
    public boolean containsKey(K key) {
        if(size() == 0) {
            return false;
        }
        
        for(K k : map.keySet()) {
            if(k.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verificar se a tabela contem um dado valor
     * @param value - o valor
     * @return true se contem o valor, false caso contrario
     */
    public boolean containsValue(V value) {
        if(size() == 0) {
            return false;
        }
        
        for(V v : map.values()) {
            if(v.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remover um par chave-valor, dada a chave
     * @param key - a chave
     * @return V - o valor previamente associado a chave
     */
    public V removeByKey(K key) {
        V value = getValue(key);
        map.remove(key);
        reverseMap.remove(value);
        
        size--;
        
        return value ;
    }

    /**
     * Remover um par chave-valor, dado o valor
     * @param value - o valor
     * @return K - a chave previamente associada ao valor
     */
    public K removeByValue(V value) {
        K key = getKey(value);
        reverseMap.remove(value);
        map.remove(key);
        
        size--;
        
        return key;
    }

    /**
     * Retornar o tamanho da tabela (numero de pares chave-valor contidos)
     * @return o tamanho da tabela
     */
    public int size() {
        return map.size();
    }

 
    
}

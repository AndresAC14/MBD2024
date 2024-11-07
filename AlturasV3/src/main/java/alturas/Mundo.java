package alturas;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Mundo {

    private List<Pais> paises;

    public Mundo() {
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }


    public void leePaises(String file) throws IOException {
        for (String datosPais: Files.readAllLines(Path.of(file)))
            try (Scanner scPais = new Scanner(datosPais)) {
                scPais.useDelimiter("[,]");
                scPais.useLocale(Locale.ENGLISH);
                String nombre = scPais.next();
                String continente = scPais.next();
                double altura = scPais.nextDouble();
                paises.add(new Pais(nombre, continente, altura));
            } catch (InputMismatchException e) {
                System.err.println("Dato no numerico en " + datosPais);
            } catch (NoSuchElementException e) {
                System.err.println("Faltan dqtos en " + datosPais);
            }
    }



    public List<String> getNombrePaises() {
        List<String> lista = new ArrayList<>();
        for (Pais pais : paises)
            lista.add(pais.continente());
        return lista;
    }

    public List<String> getNombrePaisesS() {
        return paises.stream().map(Pais::nombre)
                .collect(Collectors.toList());
    }

    public List<Pais> getPaisesDelContinente(String continente) {
        List<Pais> lista = new ArrayList<>();
        for (Pais pais : paises)
            if (pais.continente().equals(continente))
                lista.add(pais);
        return lista;
    }

    public List<Pais> getPaisesDelContinenteS(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equals(continente))
                .collect(Collectors.toList());
    }

    public List<Pais> paisesDe(List<String> continentes) {
        List<Pais> lista = new ArrayList<>();
        for (Pais pais : paises)
            if (continentes.contains(pais.continente()))
                lista.add(pais);
        return lista;
    }

    public List<Pais> paisesDeS(List<String> continentes) {
        return continentes.stream()
                .flatMap(cont -> paises.stream()
                        .filter(p -> p.continente().equals(cont)))
                .collect(Collectors.toList());
    }

    public List<Pais> getYMuestraPaisesDelContinente(String continente) {
        List<Pais> lista = new ArrayList<>();
        for (Pais pais : paises)
            if (pais.continente().equals(continente)) {
                lista.add(pais);
                System.out.println(pais);
            }
        return lista;
    }

    public List<Pais> getYMuestraPaisesDelContinenteS(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equals(continente))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public List<String> getContinentes() {
        List<String> lista = new ArrayList<>();
        for (Pais pais : paises)
            if (!lista.contains(pais.continente()))
                lista.add(pais.continente());
        return lista;
    }

    public List<String> getContinentesS() {
        return paises.stream()
                .map(Pais::continente)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getListContinentes() {
        List<String> lista = new ArrayList<>();
        for (Pais pais : paises)
            if (!lista.contains(pais.continente()))
                lista.add(pais.continente());
        lista.sort(null);
        return lista;
    }

    public List<Pais> extraeMenoresDeContinente(String continente, double maxAltura) {
        List<Pais> lista = new ArrayList<>();
        for (Pais pais : paises)
            if (pais.continente().equals(continente) &&
                    pais.altura() < maxAltura)
                lista.add(pais);
        lista.sort(null);
        return lista;
    }

    public void muestraNombrePaises() {
        for (Pais pais : paises)
            System.out.println(pais.nombre());
    }

    public boolean todosMayores(double minAltura) {
        boolean res = true;
        Iterator<Pais> it = paises.iterator();
        while (res && it.hasNext())
            res = it.next().altura() >= minAltura;
        return res;
    }

    public Optional<Pais> masBajoDeContinente(String continente, double minAltura) {
        Optional<Pais> menor = Optional.empty();
        for (Pais pais : paises)
            if (pais.continente().equals(continente))
                if (pais.altura() > minAltura)
                    if (!menor.isPresent())
                        menor = Optional.of(pais);
                    else if (menor.get().altura() > pais.altura())
                        menor = Optional.of(pais);
        return menor;
    }

    public Pais paisDeMayorAltura() {
        List<Pais> otra = new ArrayList<>(paises);
        otra.sort(Comparator.comparingDouble(Pais::altura));
        return otra.get(0);
    }

    public long numPaisesQueVerifican(Predicate<Pais> pred) {
        long sum = 0;
        for (Pais pais : paises)
            if (pred.test(pais))
                sum++;
        return sum;
    }

    public Pais[] arrayDePaises(String continente) {
        Pais[] array = new Pais[paises.size()];
        int pos = 0;
        for (Pais pais : paises)
            if (pais.continente().equals(continente)) {
                array[pos] = pais;
                pos++;
            }
        return Arrays.copyOf(array, pos);
    }

    public double sumaAlturas() {
        double suma = 0;
        for (Pais pais : paises)
            suma += pais.altura();
        return suma;
    }

    public Set<Pais> paisesOrdDelContinente(String continente) {
        Set<Pais> set = new TreeSet<>();
        for (Pais pais : paises)
            if (pais.continente().equals(continente))
                set.add(pais);
        return set;
    }

    public Set<String> continentesOrd() {
        Set<String> set = new TreeSet<>();
        for (Pais pais : paises)
            set.add(pais.continente());
        return set;
    }

    public Set<Double> alturasDelContinente(String continente) {
        Set<Double> set = new TreeSet<>();
        for (Pais pais : paises) {
            if (pais.continente().equals(continente))
                set.add(pais.altura());
        }
        return set;
    }

    public long numPaisesMenoresQue(double maxAlt) {
        long cont = 0;
        for (Pais pais : paises)
            if (pais.altura() < maxAlt)
                cont++;
        return cont;
    }

    public long numIntPaisesMenoresQue(double maxAlt) {
        int cont = 0;
        for (Pais pais : paises)
            if (pais.altura() < maxAlt)
                cont++;
        return cont;
    }

    public Map<Boolean, List<Pais>> separaPor(Predicate<Pais> pred) {
        Map<Boolean, List<Pais>> map = new HashMap<>();
        for (Pais pais : paises)
            map.computeIfAbsent(pred.test(pais), k -> new ArrayList<>()).add(pais);
        return map;
    }

    public Map<String, List<Pais>> paisesPorContinente() {
        Map<String, List<Pais>> map = new HashMap<>();
        for (Pais pais : paises)
            map.computeIfAbsent(pais.continente(), k -> new ArrayList<>()).add(pais);
        return map;
    }

    public Map<String, Long> numPaisesPorContinente() {
        Map<String, Long> map = new HashMap<>();
        for (Pais pais : paises) {
            String continente = pais.continente();
            long np = map.getOrDefault(continente, 0L);
            map.put(continente, np + 1);
        }
        return map;
    }

    public Map<String, Set<Double>> alturasPorContinente() {
        Map<String, Set<Double>> map = new TreeMap<>();
        for (Pais pais : paises) {
            String continente = pais.continente();
            Set<Double> set = map.computeIfAbsent(continente, k -> new HashSet<>());
            set.add(pais.altura());
        }
        return map;
    }

    public Map<Double, Set<String>> continentesPorAltura() {
        Map<Double, Set<String>> map = new HashMap<>();
        for (Pais pais : paises) {
            double altura = pais.altura();
            Set<String> set = map.computeIfAbsent(altura, k -> new TreeSet<>());
            set.add(pais.continente());
        }
        return map;
    }

    public Map<Double, Set<String>> continentesPorAlturaOrd() {
        Map<Double, Set<String>> map = new TreeMap<>();
        for (Pais pais : paises) {
            double altura = pais.altura();
            Set<String> set = map.computeIfAbsent(altura, k -> new TreeSet<>());
            set.add(pais.continente());
        }
        return map;
    }

    public String stringDeContinentes() {
        Set<String> set = new HashSet<>();
        StringJoiner joiner = new StringJoiner(" - ", "<", ">");
        for (Pais pais : paises) {
            String continente = pais.continente();
            if (set.add(continente))
                joiner.add(pais.continente());
        }
        return joiner.toString();
    }



/*



    public List<String> getNombrePaises() {
        return paises.stream().map(Pais::nombre)
                .collect(Collectors.toList());
    }

    public List<Pais> getPaisesDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equals(continente))
                .collect(Collectors.toList());
    }

    public List<Pais> paisesDe(List<String> continentes) {
        return List.of("Europa", "Asia", "South America").stream()
                .flatMap(cont -> paises.stream().
                                    filter(p-> p.continente().equals(cont)))
                .collect(Collectors.toList());
    }

    public List<Pais> getYMuestraPaisesDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equals(continente))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public Set<String> getContinentes() {
        return paises.stream()
                .map(Pais::continente)
                .collect(Collectors.toSet());
    }

    public List<String> getListContinentes() {
        return paises.stream()
                .map(Pais::continente)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Pais> extraeMenoresDeContinente(String continente, double maxAltura) {
            return paises.stream()
                    .filter(pais->pais.continente().equals(continente))
                    .sorted(Comparator.comparingDouble(Pais::altura))
                    .takeWhile(pais->pais.altura() < maxAltura).
                    collect(Collectors.toList());
    }

    public List<Pais> extraeMayoresDeContinente(String continente, double maxAltura) {
        return paises.stream()
                .filter(pais->pais.continente().equals(continente))
                .sorted(Comparator.comparing(Pais::altura))
                .dropWhile(pais->pais.altura() < maxAltura).
                        collect(Collectors.toList());
    }

    public void muestraNombrePaises() {
        paises.stream()
                .map(Pais::nombre)
                .forEach(System.out::println);
    }

    public boolean todosMayores(double altura) {
        return paises.stream()
                .allMatch(p -> p.altura() > altura);
    }

    public Pais masBajoDeContinente(String continente) {
        return paises.stream()
                .filter(pais->pais.continente().equals(continente))
                .sorted(Comparator.comparingDouble(Pais::altura))
                .findFirst().orElse(null);
    }

    public Pais paisMayorAltura() {
        return paises.stream()
                .max(Comparator.comparingDouble(Pais::altura))
                .get();
    }

    public long numPaisesQueVerifican(Predicate<Pais> pred) {
        return paises.stream()
                .filter(pred)
                .count();
    }

    public Pais[] arrayDePaises(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equals(continente))
                .toArray(Pais[]::new);
    }

    public double sumaAlturas() {
        return paises.stream()
                .map(Pais::altura)
                .reduce(Double::sum)
                .get();
    }

    public double suma2Alturas() {
        return paises.stream()
                .map(Pais::altura)
                .reduce(0d, Double::sum);
    }

    public double suma3Alturas() {
        return paises.stream()
                .map(Pais::altura)
                .reduce(0d, Double::sum,Double::sum);
    }

    public Set<Pais> paisesOrdDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equalsIgnoreCase(continente))
                .collect(TreeSet<Pais>::new
                        , Set::add
                        , Set::addAll);
    }

    public Set<String> paisesConColector() {
        return paises.stream()
                .map(Pais::nombre)
                .collect(new MiColector());
    }

    public Set<Double> alturasDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.getContinente().equals(continente))
                .collect(Collectors.mapping(Pais::altura
                        ,Collectors.toSet()));
    }

    public Set<Double> alturasDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.continente().equals(continente))
                .map(Pais::altura)
                .collect(Collectors.toSet());
    }

    public long numPaisesMenoresQue(double maxAlt) {
        return paises.stream()
                .filter(p -> p.altura() < maxAlt)
                .collect(Collectors.counting());
    }

    public int numIntPaisesMenoresQue(double d) {
        return paises.stream()
                .filter(p -> p.altura() < d)
                .collect(Collectors.summingInt(pais -> 1));
    }

    public Set<String> continentesOrd() {
        return paises.stream()
                .map(Pais::continente)
                .collect(
                        Collectors.toCollection(TreeSet<String>::new));
    }

    public Map<Boolean, List<Pais>> separaPor(Predicate<Pais> pred) {
        return paises.stream()
                .collect(Collectors.partitioningBy(pred));
    }

    public Map<String, List<Pais>> paisesPorContinente() {
        return paises.stream()
                .collect(Collectors.groupingBy(Pais::continente));
    }

    public Map<String, Long> numPaisesPorContinente() {
        return paises.stream()
                .collect(Collectors.groupingBy(Pais::continente
                        ,Collectors.counting()));
    }

    public Map<String, Set<Double>> alturasPorContinente() {
        return paises.stream()
                .collect(Collectors
                        .groupingBy(Pais::continente
                                ,Collectors.mapping(Pais::altura
                                        ,Collectors.toSet())));
    }

    public Map<String, Integer> numIntPaisesPorContinente() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        Pais::continente
                        ,Collectors.summingInt(p -> 1)));
    }

    public Map<Double, Set<String>> continentesPorAltura() {
        return paises
                .stream()
                .collect(Collectors.groupingBy(
                        Pais::altura
                        ,Collectors.mapping(Pais::continente,
                                Collectors.toCollection(TreeSet::new))));
    }

    public Map<Double, Set<String>> continentesPorAlturaOrd() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        Pais::altura,
                        TreeMap::new,
                        Collectors.mapping(Pais::continente
                                ,Collectors.toCollection(TreeSet::new))));
    }

    public String stringDeContinentes() {
        return paises.stream()
                .map(Pais::continente)
                .distinct()
                .collect(Collectors.joining("<", "-", ">"));
    }

    public Map<String,Long>  nppl () {
        return paises.stream()
                .map(Pais::continente)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));
    }

    public Map<String,Map<Double,Long>> nppccua() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        Pais::continente,
                        Collectors.groupingBy(
                                pais->((int)(pais.altura()*10))/10.0,
                                Collectors.counting())));
    }

    public Map<Double, Map<String, List<Pais>>> lppayc() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        pais -> ((int)(pais.altura()*10))/10.0,
                        Collectors.groupingBy(
                                Pais::continente)));
    }

    public Map<Long, Set<Integer>> nlpp() {
        Map<Integer, Long> map =
                paises.stream()
                        .collect(Collectors.groupingBy(pais -> pais.nombre().length(),
                                Collectors.counting()));
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        TreeMap::new,
                        Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toSet())));
    }

 */
}

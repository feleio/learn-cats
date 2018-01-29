//package temp;
//
//import java.util.List;
//import java.util.Optional;
//
//public class Test {
//  private static List<String> titlePatterns = "";
//
//  public static Optional<String> removeTitle(Optional<String> nameOpt) {
//    return nameOpt.map(name -> {
//      String result = name.replaceFirst(titlePatterns.concat("|").concat(titlePatterns.toUpperCase()), "");
//      if (result != null) {
//        result = result.trim();
//      }
//      return result;
//    });
//  }
//}

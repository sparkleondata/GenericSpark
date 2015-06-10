package core.analyzers

/**
 * Created by jsmammen on 5/18/15.
 */
trait AnalyzerComponent {
  def analyze(o: Any): Any
}

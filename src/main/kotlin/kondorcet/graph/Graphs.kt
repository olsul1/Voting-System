package kondorcet.graph

import kable.entry
import kable.minus
import kable.plus

/** Returns an empty [Graph] */
internal fun <V : Any, W : Any> emptyGraph(): Graph<V, W> = SimpleGraph()

/** Returns a new graph with the [vertex] added */
internal operator fun <V : Any, W : Any> Graph<V, W>.plus(vertex: V): Graph<V, W> =
        SimpleGraph(vertices + vertex, edges)

/** Returns a new graph with the [vertices] added */
internal operator fun <V : Any, W : Any> Graph<V, W>.plus(vertices: Collection<V>): Graph<V, W> =
        SimpleGraph(this.vertices + vertices, edges)

/** Returns a new graph with the [edge] added */
internal operator fun <V : Any, W : Any> Graph<V, W>.plus(edge: Edge<V, W>): Graph<V, W> =
        SimpleGraph(vertices + edge.source + edge.target, edges + entry(edge.source, edge.target, edge.weight))

/** Returns a new graphs without the given [vertex] */
internal operator fun <V : Any, W : Any> Graph<V, W>.minus(vertex: V): Graph<V, W> =
        SimpleGraph(vertices - vertex, edges)

/** Returns a new graphs without the given [edge] */
internal operator fun <V : Any, W : Any> Graph<V, W>.minus(edge: Pair<V, V>): Graph<V, W> =
        SimpleGraph(vertices, edges - edge)
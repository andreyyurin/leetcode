data class TrieNode(
    val value: String,
    val parent: TrieNode? = null,
    val children: HashMap<String, TrieNode> = hashMapOf(),
    var structure: String = ""
) 

class Solution {
    fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
        val root = TrieNode(
            parent = null,
            value = "/"
        )

        paths.forEach { path ->
            var prevFolder = root

            path.forEach { folderName ->
                prevFolder = prevFolder.children.getOrPut(
                    folderName
                ) {
                    TrieNode(
                        value = folderName,
                        parent = prevFolder
                    )
                }
            }
        }

        computeStructure(root)

        val structureMap = hashMapOf<String, MutableList<TrieNode>>()
        fillStructureMap(structureMap, root)
        structureMap.forEach { (structure, nodes) ->
            if (nodes.size > 1) {
                nodes.forEach { rmNode ->
                    rmNode?.parent?.children?.remove(rmNode.value)
                }
            }
        }

        val res = mutableListOf<List<String>>()
        findPaths(node = root, res = res, path = mutableListOf())

        return res   
    }

    private fun findPaths(
        node: TrieNode,
        res: MutableList<List<String>>,
        path: MutableList<String>,
    ) {
        path.add(node.value)
        
        if (path.size > 1) {
            res.add(path.drop(1)) // drop the root node
        } 

        node.children.forEach { (folder, trieNode) -> 
            findPaths(trieNode, res, path)
        }

        path.removeLast()
    }

    fun computeStructure(node: TrieNode): String {
        if (node.children.isEmpty()) {
            node.structure = ""
            return ""
        }

        val childStructures = node.children.entries
            .sortedBy { it.key }
            .joinToString("") { (key, child) ->
                "(${key}${computeStructure(child)})"
            }

        node.structure = childStructures
        return childStructures
    }

    private fun fillStructureMap(
        map: HashMap<String, MutableList<TrieNode>>,
        node: TrieNode
    ) {
        if (node.value != "/" && node.structure.isNotEmpty()) {
            map[node.structure] = (map[node.structure] ?: mutableListOf()).also {
                it.add(node)
            }
        }

        node.children.forEach { (_, chNode) ->
            fillStructureMap(map, chNode)
        }
    }
}
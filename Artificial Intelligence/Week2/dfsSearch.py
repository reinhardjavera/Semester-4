import matplotlib.pyplot as plt
import networkx as nx

def draw_graph_with_highlighted_node(G, pos, node_colors):
    plt.clf()  
    nx.draw(G, pos, with_labels=True, node_color=node_colors, node_size=700, edge_color='k', linewidths=1, font_size=15, arrows=True)
    edge_labels = nx.get_edge_attributes(G, 'weight')
    nx.draw_networkx_edge_labels(G, pos, edge_labels=edge_labels)
    plt.pause(1)  

def dfs_visit(G, pos, node, visited, node_colors):
    visited.add(node)
    node_colors[node] = 'red'  
    draw_graph_with_highlighted_node(G, pos, [node_colors.get(node, 'skyblue') for node in G.nodes()])
    for neighbor in G.neighbors(node):
        if neighbor not in visited:
            dfs_visit(G, pos, neighbor, visited, node_colors)
    node_colors[node] = 'skyblue'  

def dfs(G, pos, start_node):
    visited = set()
    node_colors = {}
    dfs_visit(G, pos, start_node, visited, node_colors)

G = nx.DiGraph()
edges = [
    ('s', 'a', 3), ('s', 'b', 6), ('s', 'c', 2), ('a', 'd', 3), ('c', 'e', 1),
    ('b', 'd', 4), ('b', 'g', 9), ('b', 'e', 2), ('e', 'f', 6), ('e', 'h', 5),
    ('d', 'f', 5), ('h', 'g', 8), ('f', 'g', 5)
]
for edge in edges:
    G.add_edge(edge[0], edge[1], weight=edge[2])

pos = {'s': (0, 1), 'a': (1, 2), 'b': (1, 1), 'c': (1, 0), 'd': (2, 2), 'e': (2, 0), 'f': (3, 1), 'g': (4, 0), 'h': (3, 0)}

plt.figure(figsize=(10, 8))
dfs(G, pos, 's')
plt.show()

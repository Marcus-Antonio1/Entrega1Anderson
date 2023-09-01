import xml.etree.ElementTree as ET

tree = ET.parse('passageiros.xml')
root = tree.getroot()

numero_passageiros = len(root)
print(f"Número de passageiros: {numero_passageiros}\n")

origens = set()
destinos = set()

for passageiro in root:
    origem = passageiro.find('origem').text
    destino = passageiro.find('destino').text
    origens.add(origem)
    destinos.add(destino)

print("Origens:", ', '.join(origens))
print("Destinos:", ', '.join(destinos))
